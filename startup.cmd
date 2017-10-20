
TITLE startup

SET SLEEP=ping 127.0.0.1 /n
SET PROJECT_PATH=D:\EclipseWorkspaces\SpringCloud\wfw
SET VERSION=1.5.3

%SLEEP% 1 > nul
SET SERVICE_NAME=wfw-registration-center
START CMD /K "TITLE %SERVICE_NAME% && java -jar %PROJECT_PATH%\%SERVICE_NAME%\target\%SERVICE_NAME%-%VERSION%.jar"

%SLEEP% 5 > nul
SET SERVICE_NAME=wfw-config-server
START CMD /K "TITLE %SERVICE_NAME% && java -jar %PROJECT_PATH%\%SERVICE_NAME%\target\%SERVICE_NAME%-%VERSION%.jar"

%SLEEP% 5 > nul
SET SERVICE_NAME=wfw-provider-user
START CMD /K "TITLE %SERVICE_NAME% && java -jar %PROJECT_PATH%\%SERVICE_NAME%\target\%SERVICE_NAME%-%VERSION%.jar"

%SLEEP% 5 > nul
SET SERVICE_NAME=wfw-consumer-user
START CMD /K "TITLE %SERVICE_NAME% && java -jar %PROJECT_PATH%\%SERVICE_NAME%\target\%SERVICE_NAME%-%VERSION%.jar"

%SLEEP% 5 > nul
SET SERVICE_NAME=wfw-consumer-user-feign
START CMD /K "TITLE %SERVICE_NAME% && java -jar %PROJECT_PATH%\%SERVICE_NAME%\target\%SERVICE_NAME%-%VERSION%.jar"

%SLEEP% 5 > nul
SET SERVICE_NAME=wfw-api-gateway
START CMD /K "TITLE %SERVICE_NAME% && java -jar %PROJECT_PATH%\%SERVICE_NAME%\target\%SERVICE_NAME%-%VERSION%.jar"

REM 将休眠时间设置长一点，确保config-server已经启动，config-client能够从config-server读取配置信息，否则config-client会报Could not resolve placeholder 'hello' in string value的错误而无法启动
%SLEEP% 25 > nul
SET SERVICE_NAME=wfw-config-client
START CMD /K "TITLE %SERVICE_NAME% && java -jar %PROJECT_PATH%\%SERVICE_NAME%\target\%SERVICE_NAME%-%VERSION%.jar"
