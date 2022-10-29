import sys
from bluetooth_battery import BatteryStateQuerier, BatteryQueryError, BluetoothError
import sys,time

##soundcore_p3_addr = 

print("Querying...")

class BatteryQuery:

    def __init__(self,addr):
        self.addr = addr
        return

    def performQuery(self):
        
        try:
            query = BatteryStateQuerier(self.addr) 
            return int(query)

        except BluetoothError as e:
            return -1
            # Handle device is offline

        except BatteryQueryError as e:
            return -1
            # Handle device is unsupported



    
                                          # Can raise BluetoothError when device is down or port is wrong
                                                    # Can raise BatteryQueryError when the device is unsupported
