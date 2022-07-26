import requests
import json
import time

while(1):
    #Get json from jsonbin.io
    url = 'https://api.jsonbin.io/v3/b/62daf33f2c868775a53389d5/latest'
    headers = {
    'X-Master-Key': '$2b$10$Jey0JZy.YVYlPVIxIxadAeoxN3bnvkcEywwA8zAZoZGvfgJPoJ6Q2'
    }

    req = requests.get(url, json=None, headers=headers)

    #Convert string to dict as json
    bat_obj = json.loads(req.text)

    #Get device dict
    r = bat_obj['record']

    print(r)

    #Print all percentages from dict and notify 
    for d in r:

        device = r[d]
        percentage = int(device['percentage'])

        if(percentage < 30):
            print(d + " : " + device['percentage'] +"%. This device needs to charge!")
        
        else:
            print(d + " : " + device['percentage'] +"%")

    #While interation every hour
    time.sleep(60*60)

