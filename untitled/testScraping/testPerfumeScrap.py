import subprocess

import requests as requests
from selenium import webdriver
from selenium.webdriver.chrome.options import Options
from selenium.webdriver.common.keys import Keys
import time
# 이미지 파일을 저장할 폴더 경로 설정
import os
# 이미지 저장을 위한 라이브러리
from urllib.request import urlretrieve, urlopen

# 크롬창 자동으로 켜지게 설정
# subprocess.Popen(r'C:\Program Files (x86)\Google\Chrome\Application\chrome.exe'
#                  r' --remote-debugging-port=9222 --user-data-dir="C:\chrometemp"')

# 크롬 디버깅 모드 진입을 위한 포트번호 설정
chrome_options = Options()
chrome_options.add_experimental_option("debuggerAddress", "127.0.0.1:9222")

# 크롬 드라이버로 url 주소 진입
chrome_driver = 'D:/chromedriver.exe'
driver = webdriver.Chrome(chrome_driver, options=chrome_options)

# 프레그런티카 진입 (시간은 사람인 척 하기 위해 수동으로 조절)
driver.get('https://www.fragrantica.com/search/')
time.sleep(4)

# 향수 리스트 저장
perfume_link = driver.find_elements_by_css_selector('.card-section > p > a')
links = []

# 선택된 태그에서 링크 저장하기
for i in perfume_link:
    link = i.get_attribute('href')
    links.append(link)

# 상세페이지에서 각 정보 저장하는 반복문
for click_link in links:
    # 각 향수 상세정보 링크로 진입
    driver.get(click_link)
    time.sleep(5)
    print('-' * 50 + '\n')

    # 향수 이름 출력하기
    name = driver.find_element_by_css_selector('#toptop > h1')
    print(name.text)

    # 향수 브랜드 출력
    brand = driver.find_element_by_xpath('//*[@id="main-content"]/div[1]/div[1]/div/div[2]/div[1]/div[2]/p/a/span')
    print(brand.text)

    # 향의 조합 (accord) 출력
    accords = driver.find_elements_by_css_selector('.accord-bar')
    for i in accords:
        accord = i.get_attribute('style')
        print(i.text + ': ' + accord)

    # 향수 소지 여부 출력
    possession = driver.find_elements_by_css_selector('#rating > div div div div:nth-child(2) span')
    possession_ratio = driver.find_elements_by_css_selector('#rating > div div div div.voting-small-chart-size div div')
    for i in possession:
        possess = i.text
        print(possess)
    for j in possession_ratio:
        ratio = j.get_attribute('style')
        print(ratio)

    # 향수 선호도 출력
    preference = driver.find_elements_by_css_selector('')