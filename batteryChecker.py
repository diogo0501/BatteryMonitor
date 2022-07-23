import bluetooth
#import PyOBEX

#b = bluetooth.BluetoothSocket(bluetooth.RFCOMM)

#b.bind(('127.0.0.1', 123))
#print(b.accept())
print(bluetooth.discover_devices(duration=8, flush_cache=True, lookup_names=True))

