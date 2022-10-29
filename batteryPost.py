import requests
import json
import time
from batteryChecker import BatteryQuery

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

    print(r)

    soundcorep3_addr = "AC:12:2F:C8:D9:BE"

    #Print all percentages from dict and notify 
    if 'SoundcoreP3' in r:

        query = BatteryQuery(soundcorep3_addr)

        device = r['SoundcoreP3']

        perc = query.performQuery()

        if(perc != -1):
            device['percentage'] = perc
        else:
            printf("Error on querying and consequently saving percentage")
            break

        print(r)

    ans = requests.put(url,json=r,headers=headers)
    print(ans.text)

    print("Put done")

    #While interation every hour
    time.sleep(60*60)