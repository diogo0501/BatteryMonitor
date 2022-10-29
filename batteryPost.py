import requests
import json
import time
from batteryChecker import BatteryQuery
from upower_python.upower import UPowerManager
import math 

dev_list = ['SoundCoreP3','LogKeyboard']

def main():

    while(1):
        #Get json from jsonbin.io
        url = 'https://api.jsonbin.io/v3/b/62daf33f2c868775a53389d5'
        headers = {
            'Content-type' : 'application/json',
            'X-Master-Key': '$2b$10$Jey0JZy.YVYlPVIxIxadAeoxN3bnvkcEywwA8zAZoZGvfgJPoJ6Q2'
        }

        req = requests.get(url, json=None, headers=headers)

        #Convert string to dict as json
        bat_obj = json.loads(req.text)

        #Get device dict
        r = bat_obj['record']
        
        putPercentageHandler(dev_list,r)

        print(r)

        ans = requests.put(url,json=r,headers=headers)

        print(ans.text)

        print("Put done")

        #While interation every hour
        time.sleep(5)


def putPercentageHandler(device_list,json):

    percs = []
    for device in device_list:

        if device == 'SoundCoreP3':
            new_perc = getSoundCoreBatLevel()
            percs.append((device,new_perc))

        elif device == 'LogKeyboard':
            new_perc = getLogKeyboardBatLevel()
            percs.append((device,new_perc))

    for dev,perc in percs:

        device = json[dev]

        if(perc != -1):

            device['percentage'] = perc

        
    return #...

    

def getSoundCoreBatLevel():

    soundcorep3_addr = "AC:12:2F:C8:D9:BE"

    query = BatteryQuery(soundcorep3_addr)

    perc = query.performQuery()

    return perc

def getLogKeyboardBatLevel():
    
    bat_name = '/org/freedesktop/UPower/devices/keyboard_hidpp_battery_0'

    u = UPowerManager()

    new_perc = math.floor(u.get_device_percentage(bat_name))

    print(new_perc)

    return new_perc


if __name__ == '__main__':
    main()