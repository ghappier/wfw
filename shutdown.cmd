
TITLE shutdown

SET SLEEP=ping 127.0.0.1 /n

%SLEEP% 1 > nul
SET SERVICE_NAME=wfw-registration-center
TASKKILL /FI "WINDOWTITLE eq %SERVICE_NAME%*" /IM cmd.exe /F /T

%SLEEP% 1 > nul
SET SERVICE_NAME=wfw-provider-user
TASKKILL /FI "WINDOWTITLE eq %SERVICE_NAME%*" /IM cmd.exe /F /T

%SLEEP% 1 > nul
SET SERVICE_NAME=wfw-consumer-user
TASKKILL /FI "WINDOWTITLE eq %SERVICE_NAME%*" /IM cmd.exe /F /T

%SLEEP% 1 > nul
SET SERVICE_NAME=wfw-consumer-user-feign
TASKKILL /FI "WINDOWTITLE eq %SERVICE_NAME%*" /IM cmd.exe /F /T

%SLEEP% 1 > nul
SET SERVICE_NAME=wfw-api-gateway
TASKKILL /FI "WINDOWTITLE eq %SERVICE_NAME%*" /IM cmd.exe /F /T

%SLEEP% 1 > nul
SET SERVICE_NAME=wfw-config-server
TASKKILL /FI "WINDOWTITLE eq %SERVICE_NAME%*" /IM cmd.exe /F /T

%SLEEP% 1 > nul
SET SERVICE_NAME=wfw-config-client
TASKKILL /FI "WINDOWTITLE eq %SERVICE_NAME%*" /IM cmd.exe /F /T
