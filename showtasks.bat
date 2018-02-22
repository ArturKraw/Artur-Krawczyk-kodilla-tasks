call runcrud.bat
if "%ERRORLEVEL%" == "0" goto browse_thispage
echo.
echo RUNCRUD has errors - breaking work
goto fail

:browse_thispage
@start firefox http://localhost:8080/crud/v1/task/%1
if "%ERRORLEVEL%" == "0" goto end
echo Cannot open browser or/and this page
goto fail

:fail
echo.
echo There were errors

:end
echo.
echo Work is finished.