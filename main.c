#include <stdio.h>


int main() {
    
    // Checking for windows OS with 
    // _WIN32 macro 
    #ifdef _WIN32 
        #define PLATAFORM_NAME "Windows"
        #include <Windows.h>
    
    // Checking for mac OS with 
    // __APPLE__ macro 
    #elif __APPLE__ 
        #define PLATAFORM_NAME "MACOS"
    
    // Checking for linux OS with 
    // __linux__ macro 
    #elif __linux__ 
        #define PLATAFORM_NAME "LINUX"
        #define PATH_BATT_CHARGE_NOW "/sys/class/power_supply/BAT0/subsystem/BAT0/energy_now"
        #define PATH_BATT_CHARGE_FULL "/sys/class/power_supply/BAT0/subsystem/BAT0/energy_full"
    
    // Checking for MAC OS with 
    // TARGET_OS_MAC macro 
    #elif TARGET_OS_MAC 
        #define PLATAFORM_NAME "MACOS"
    
    // Checking for Android OS with 
    // __ANDROID__ macro 
    #elif __ANDROID__ 
        #define PLATAFORM_NAME "ANDROID"
    
    #else 
        #define PLATAFORM_NAME "NOTFOUND"

    #endif 

        printf("[INFO] Plataform Name : %s\n", PLATAFORM_NAME);

        if(PLATAFORM_NAME == "LINUX") {
        
            int chargedPercent = 0;

            FILE *battChargeNow;
            FILE *battChargeFull;
            long unsigned int battMax_mAh = 0;
            long unsigned int battRemain_mAh = 0;

            if (NULL == (battChargeNow = fopen(PATH_BATT_CHARGE_NOW,
                                                 "r")))
            {
                fclose(battChargeNow);
                return -1;
            }
            if (NULL == (battChargeFull = fopen(PATH_BATT_CHARGE_FULL, 
                                                "r")))
            {
                fclose(battChargeNow);
                fclose(battChargeFull);
                return -1;
            }

            fscanf((FILE *)battChargeFull, "%lu", &battMax_mAh);
            fscanf((FILE *)battChargeNow, "%lu", &battRemain_mAh);

            chargedPercent = 100.00 * ((float)battRemain_mAh 
                                / (float)battMax_mAh);
            printf("[INFO] Battery percentage : %d%%\n", 
                            chargedPercent);  

            return 0; 
        }

        else if(PLATAFORM_NAME == "WINDOWS") {
            SYSTEM_POWER_STATUS status;
            if(GetSystemPowerStatus(&status)) {
                unsigned char battery = status.BatteryLifePercent;
                /* battery := 0..100 or 255 if unknown */
                if(battery == 255) {
                    printf("Battery level unknown !");
                }
                else {
                    printf("Battery level : %u%%.", battery);
                }
            } 
            else {
                printf("Cannot get the power status, error %lu", GetLastError()); 
            }
        }
        return 0; 


    
}