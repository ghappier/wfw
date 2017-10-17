
TITLE shutdown

SET SLEEP=ping 127.0.0.1 /n

%SLEEP% 1 > nul
SET SERVICE_NAME=wfw-registration-center
TASKKILL /FI "WINDOWTITLE eq %SERVICE_NAME%*" /IM cmd.exe /F /T
