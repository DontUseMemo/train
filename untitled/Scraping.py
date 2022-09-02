import subprocess

from selenium import webdriver
from selenium.webdriver.chrome.options import Options
from selenium.webdriver.common.by import By
from selenium.webdriver.support.ui import WebDriverWait
from selenium.webdriver.support import expected_conditions as EC

# driver = webdriver.Chrome(r'D:/chromedriver.exe')
#
# subprocess.Popen(r'C:\Program Files (x86)\Google\Chrome\Application\chrome.exe'
#                  r' --remote-debugging-port=9222 --user-data-dir="C:\chrometemp"')
#
# option = Options()
# option.add_experimental_option("debuggerAddress", "127.0.0.1:9222")
#
# chrome_ver = chromedriver_autoinstaller.get_chrome_version().split('.')[0]
# try:
#     driver = webdriver.Chrome(f'./{chrome_ver}/chromedriver.exe', options=option)
# except:
#     chromedriver_autoinstaller.install(True)
#     driver = webdriver.Chrome(f'./{chrome_ver}/chromedriver.exe', options=option)
# driver.implicitly_wait(10)

# 크롬 주소 :
# C:\Program Files (x86)\Google\Chrome\Application\chrome.exe --remote-debugging-port=9222 --user-data-dir="C:/ChromeTEMP"

# 크롬 디버깅 모드 진입을 위한 포트번호 설정
chrome_options = Options()
chrome_options.add_experimental_option("debuggerAddress", "127.0.0.1:9222")

# 크롬 드라이버로 프래그런티카 주소 진입
chrome_driver = 'D:/chromedriver.exe'
driver = webdriver.Chrome(chrome_driver, options=chrome_options)
driver.get("https://www.fragrantica.com/")

# 기다리는 시간은 6초로 고정
wait = WebDriverWait(driver, 6)

try:
    wait.until(EC.presence_of_element_located((By.CLASS_NAME, 'gLFyf')))
finally:
    driver.quit()
