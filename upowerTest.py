from upower_python.upower import UPowerManager

u = UPowerManager()

dev = u.detect_devices()

dis = u.get_display_device()

bat = u.get_device_percentage('/org/freedesktop/UPower/devices/keyboard_hidpp_battery_0')

print(bat)


print(dis)
