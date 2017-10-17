
TITLE startup

SET SLEEP=ping 127.0.0.1 /n
SET PROJECT_PATH=D:\EclipseWorkspaces\SpringCloud\wfw
SET VERSION=1.1.0

%SLEEP% 1 > nul
SET SERVICE_NAME=wfw-registration-center
START CMD /K "TITLE %SERVICE_NAME% && java -jar %PROJECT_PATH%\%SERVICE_NAME%\target\%SERVICE_NAME%-%VERSION%.jar"

%SLEEP% 5 > nul
SET SERVICE_NAME=wfw-provider-user
START CMD /K "TITLE %SERVICE_NAME% && java -jar %PROJECT_PATH%\%SERVICE_NAME%\target\%SERVICE_NAME%-%VERSION%.jar"
