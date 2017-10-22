
TITLE startup

SET SLEEP=ping 127.0.0.1 /n
SET PROJECT_PATH=D:\EclipseWorkspaces\SpringCloud\wfw
SET VERSION=1.5.5

REM 为了减少内存占用（正式环境请不要这么做），用-Xmx128M限制最大内存为128M，注意，-Xmx128M参数要紧跟在java命令之后。

%SLEEP% 1 > nul
SET SERVICE_NAME=wfw-registration-center
START CMD /K "TITLE %SERVICE_NAME% && java -Xmx128M -jar %PROJECT_PATH%\%SERVICE_NAME%\target\%SERVICE_NAME%-%VERSION%.jar"

%SLEEP% 10 > nul
SET SERVICE_NAME=wfw-config-server
START CMD /K "TITLE %SERVICE_NAME% && java -Xmx128M -jar %PROJECT_PATH%\%SERVICE_NAME%\target\%SERVICE_NAME%-%VERSION%.jar"

%SLEEP% 30 > nul
SET SERVICE_NAME=wfw-provider-user
START CMD /K "TITLE %SERVICE_NAME% && java -Xmx128M -jar %PROJECT_PATH%\%SERVICE_NAME%\target\%SERVICE_NAME%-%VERSION%.jar"

%SLEEP% 5 > nul
SET SERVICE_NAME=wfw-consumer-user
START CMD /K "TITLE %SERVICE_NAME% && java -Xmx128M -jar %PROJECT_PATH%\%SERVICE_NAME%\target\%SERVICE_NAME%-%VERSION%.jar"

%SLEEP% 5 > nul
SET SERVICE_NAME=wfw-consumer-user-feign
START CMD /K "TITLE %SERVICE_NAME% && java -Xmx128M -jar %PROJECT_PATH%\%SERVICE_NAME%\target\%SERVICE_NAME%-%VERSION%.jar"

%SLEEP% 5 > nul
SET SERVICE_NAME=wfw-api-gateway
START CMD /K "TITLE %SERVICE_NAME% && java -Xmx128M -jar %PROJECT_PATH%\%SERVICE_NAME%\target\%SERVICE_NAME%-%VERSION%.jar"

REM 为确保config-client能够从config-server读取配置信息，config-client启动时要确保config-server已经启动，否则config-client会报Could not resolve placeholder 'hello' in string value的错误而无法启动
%SLEEP% 5 > nul
SET SERVICE_NAME=wfw-config-client
START CMD /K "TITLE %SERVICE_NAME% && java -Xmx128M -jar %PROJECT_PATH%\%SERVICE_NAME%\target\%SERVICE_NAME%-%VERSION%.jar"
