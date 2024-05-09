#include <stdio.h>
#include <curl/curl.h>


#define X_MASTER_KEY "$2a$10$hKVDv2vtx/ZApZZRI3ov6uevvED2fa64FLzJ51ZlTPOfaI6nIFx76 "
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
                                                 "r"))) {
                fclose(battChargeNow);
                return -1;
            }
            if (NULL == (battChargeFull = fopen(PATH_BATT_CHARGE_FULL, 
                                                "r"))) {
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

            
            CURL *curl;
            CURLcode res;
            
            // Initialize curl
            curl = curl_easy_init();
            if(curl) {
                // Set the URL for the POST request
                curl_easy_setopt(curl, CURLOPT_URL, 
                                "https://api.jsonbin.io/v3/b");

                // Set the request headers
                struct curl_slist *headers = NULL;
                headers = curl_slist_append(headers, 
                                    "Content-Type: application/json");
                char key_header[50];
                sprintf(key_header, "X-Master-Key: %s", X_MASTER_KEY);
                
                headers = curl_slist_append(headers, 
                            key_header);
                curl_easy_setopt(curl, CURLOPT_HTTPHEADER, headers);
                char json[50];

                sprintf(json, "{\"PC LINUX Based\": \"%d\"}", chargedPercent);
                // Set the POST data
                curl_easy_setopt(curl, CURLOPT_POSTFIELDS, json);

                // Perform the request
                res = curl_easy_perform(curl);
                if(res != CURLE_OK)
                    fprintf(stderr, "curl_easy_perform() failed: %s\n", curl_easy_strerror(res));

                // Clean up after the request
                curl_slist_free_all(headers);
                curl_easy_cleanup(curl);
            }

            return 0; 
        }

        // else if(PLATAFORM_NAME == "WINDOWS") {
        //     SYSTEM_POWER_STATUS status;
        //     if(GetSystemPowerStatus(&status)) {
        //         unsigned char battery = status.BatteryLifePercent;
        //         /* battery := 0..100 or 255 if unknown */
        //         if(battery == 255) {
        //             printf("Battery level unknown !");
        //         }
        //         else {
        //             printf("Battery level : %u%%.", battery);
        //         }
        //     } 
        //     else {
        //         printf("Cannot get the power status, error %lu", GetLastError()); 
        //     }

        //     return 0;
        // }
        return 0; 


    
}