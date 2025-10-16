@echo off
echo Starting Spring Boot Backend...
cd /d "c:\Users\Aakarshak\OneDrive\Desktop\mynew\internship assesment\backend\backend"

echo Cleaning previous build...
if exist target rmdir /s /q target

echo Compiling with Maven Wrapper...
call mvnw.cmd clean compile

if %ERRORLEVEL% NEQ 0 (
    echo Compilation failed. Trying to run directly...
    pause
    exit /b 1
)

echo Running Spring Boot Application...
call mvnw.cmd spring-boot:run

pause