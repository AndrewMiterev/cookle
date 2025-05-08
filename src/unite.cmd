@echo off
setlocal

set OUTPUT_FILE=combined.txt

if exist %OUTPUT_FILE% del %OUTPUT_FILE%

for /R %%f in (*.*) do (
    echo --- %%~f --- >> %OUTPUT_FILE%
    type "%%f" >> %OUTPUT_FILE%
    echo. >> %OUTPUT_FILE%
)

echo READY: %OUTPUT_FILE%
endlocal
pause
