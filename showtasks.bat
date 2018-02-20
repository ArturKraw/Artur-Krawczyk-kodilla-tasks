call runcrud.bat
if "%ERRORLEVEL%" == "0" goto open_browser
echo.
echo RUNCRUD has errors - breaking work
goto fail

:open_browser
start chrome https://www.google.com
if "%ERRORLEVEL%" == "0" goto open_thispage
echo Cannot open browser
goto fail

:open_thispage
start chrome http://localhost:8080/crud/v1/task/getTasks
if "%ERRORLEVEL%" == "0" goto end
goto end

:fail
echo.
echo There were errors

:end
echo.
echo Work is finished.