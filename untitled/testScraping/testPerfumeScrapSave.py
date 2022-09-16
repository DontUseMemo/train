import subprocess

import cx_Oracle
import requests as requests
from selenium import webdriver
from selenium.webdriver.chrome.options import Options
from selenium.webdriver.common.keys import Keys
import time
# 이미지 파일을 저장할 폴더 경로 설정
import os
# 이미지 저장을 위한 라이브러리
from urllib.request import urlretrieve, urlopen

# 오라클 클라우드 연결
cx_Oracle.init_oracle_client(lib_dir=r'D:\instantclient_21_6')
connection = cx_Oracle.connect(user='admin', password='1633zhffrpxmQ', dsn='db20220705101934_high')
oracleCursor = connection.cursor()

# 데이터베이스에 저장해보기
# oracleCursor.execute('create table python (name varchar2(20), data varchar2(20))')
# rows = [(12356)]
# rows = ('dfe', 'dfef')
# oracleCursor.execute("insert into python(name, data) values (:1, :2)", rows)
# connection.commit()

# 크롬창 자동으로 켜지게 설정
subprocess.Popen(r'C:\Program Files (x86)\Google\Chrome\Application\chrome.exe'
                 r' --remote-debugging-port=9222 --user-data-dir="C:\chrometemp"')

# 크롬 디버깅 모드 진입을 위한 포트번호 설정
chrome_options = Options()
chrome_options.add_experimental_option("debuggerAddress", "127.0.0.1:9222")

# 크롬 드라이버로 url 주소 진입
chrome_driver = 'D:/chromedriver.exe'
driver = webdriver.Chrome(chrome_driver, options=chrome_options)

# 프레그런티카 진입 (시간은 사람인 척 하기 위해 수동으로 조절)
driver.get('https://www.fragrantica.com/search/')
time.sleep(4)

# oracleCursor.execute('drop table perfume_info')
# oracleCursor.execute('drop table accords')
# oracleCursor.execute('drop table perfume_note')
# oracleCursor.execute('drop table perfumer_list')
# connection.commit()
#
#
# # 데이테베이스 테이블 생성
# # --향수 테이블
# oracleCursor.execute('create table perfume_info(perfume_name varchar2(70), gender varchar2(18), brand varchar2(30), '
#                      'have varchar2(7), had varchar2(7), want varchar2(7), love varchar2(7), likes varchar2(7), '
#                      'ok varchar2(7), dislike varchar2(7), hate varchar2(7), winter varchar2(7), spring varchar2(7), '
#                      'summer varchar2(7), fall varchar2(7), days varchar2(7), night varchar2(7), '
#                      'article varchar2(500), perfumer varchar2(7), img varchar2(74))')
# # --향수 조합 테이블
# oracleCursor.execute('create table accords(perfume_name varchar2(70), scent_name varchar2(20), ratio varchar2(7))')
# # --사용한 향조 테이블
# oracleCursor.execute('create table perfume_note(perfume_name varchar2(70), note_group varchar2(7), note varchar2(20))')
# # --향수 조향사 테이블
# oracleCursor.execute('create table perfumer_list(perfume_name varchar2(70), perfumer varchar2(20))')
# print('테이블 생성 완료')
# connection.commit()

# 향수 저장할 숫자만큼 자바스크립트 버튼 누르기

# 향수 상세 리스트 가져오기
perfume_links = driver.find_elements_by_css_selector('.card-section > p > a')
links = []

# 선택된 태그에서 상세 링크 저장하기
for i in perfume_links:
    link = i.get_attribute('href')
    links.append(link)

# 향수 제목 리스트 가져오기
perfume_names = driver.find_elements_by_css_selector('.cell.card.fr-news-box div:nth-child(2) p a')
name_list = []
index = 0

# 선택된 태그에서 향수 제목 저장하기
for i in perfume_names:
    name_list.append(i.text)

# 이미 저장된 중복 링크 거르기
# for i in name_list:
#     param = [name_list[index]]
#     oracleCursor.execute('select perfume_name from perfume_info where perfume_name=:1', param)
#     isThisNameExist = oracleCursor.fetchone()
#
#     if isThisNameExist is not None:
#         print(isThisNameExist)
#         index += 1
#         continue
#     else:
#         print(name_list[index] + '부터 저장 시작')
#         break

# 각 테이블에 저장할 딕셔너리
insert_perfume_info = {}
insert_accords = {}
insert_perfume_note = {}
insert_perfumer_list = []

# 상세페이지에서 각 정보 출력하는 반복문
for click_link in links:
    # 각 향수 상세정보 링크로 진입
    driver.get(click_link)
    time.sleep(5)
    print('-' * 50 + '\n')

    # 향수 이름 저장
    name = driver.find_element_by_xpath('//*[@id="main-content"]/div[1]/div[1]/div/div[2]/div[5]/div/p[1]/b[1]')
    insert_perfume_info['perfume_name'] = name.text

    # 향수 젠더 출력
    gender = driver.find_element_by_css_selector('#toptop > h1 small')
    insert_perfume_info['gender'] = gender.text

    # 향수 브랜드 출력
    brand = driver.find_element_by_xpath('//*[@id="main-content"]/div[1]/div[1]/div/div[2]/div[1]/div[2]/p/a/span')
    insert_perfume_info['brand'] = brand.text

    # 향의 조합 (accord) 출력
    accords = driver.find_elements_by_css_selector('.accord-bar')
    for i in accords:
        accord = i.get_attribute('style')
        accordChangeString = str(accord)
        accordWidth = accordChangeString.split(" ")
        insert_accords['perfume_name'] = name.text
        insert_accords['scent_name'] = i.text
        insert_accords['ratio'] = accordWidth.pop(11).strip('%;')

    # 향수 소지 여부 출력
    count = 0
    possessions = driver.find_elements_by_css_selector('#rating > div div div div.voting-small-chart-size div div')
    for j in possessions:
        possession = j.get_attribute('style')
        possessionChangeString = str(possession)
        possessionWidth = possessionChangeString.split(" ")
        possession_ratio = possessionWidth.pop(9).strip('%;')
        if count == 0:
            insert_perfume_info['have'] = possession_ratio
            count += 1
        elif count == 1:
            insert_perfume_info['had'] = possession_ratio
            count += 1
        else:
            insert_perfume_info['want'] = possession_ratio

    # 향수 선호도와 향수 무드 출력
    count = 0
    column_count = 0
    preferences = driver.find_elements_by_css_selector('.cell.small-6 > div div .voting-small-chart-size > div > div')
    for i in preferences:
        preference = i.get_attribute('style')
        preferenceChangeString = str(preference)
        preferenceWidth = preferenceChangeString.split(" ")
        preference_ratio = preferenceWidth.pop(9).strip('%;')
        if count < 5:
            if column_count == 0:
                insert_perfume_info['love'] = preference_ratio
                column_count += 1
            elif column_count == 1:
                insert_perfume_info['likes'] = preference_ratio
                column_count += 1
            elif column_count == 2:
                insert_perfume_info['ok'] = preference_ratio
                column_count += 1
            elif column_count == 3:
                insert_perfume_info['dislike'] = preference_ratio
                column_count += 1
            else:
                insert_perfume_info['hate'] = preference_ratio
                column_count = 0
        else:
            if column_count == 0:
                insert_perfume_info['winter'] = preference_ratio
                column_count += 1
            elif column_count == 1:
                insert_perfume_info['spring'] = preference_ratio
                column_count += 1
            elif column_count == 2:
                insert_perfume_info['summer'] = preference_ratio
                column_count += 1
            elif column_count == 3:
                insert_perfume_info['fall'] = preference_ratio
                column_count += 1
            elif column_count == 4:
                insert_perfume_info['days'] = preference_ratio
                column_count += 1
            else:
                insert_perfume_info['night'] = preference_ratio
        count += 1

    # 향수 설명글 출력
    perfume_article = driver.find_element_by_xpath('//*[@id="main-content"]/div[1]/div[1]/div/div[2]/div[5]/div/p[1]')
    insert_perfume_info['article'] = perfume_article.text

    # 조향사 1명 이상 출력
    perfumers = driver.find_elements_by_css_selector('#main-content > div.grid-x.grid-margin-x > div.small-12.medium-12'
                                                     '.large-9.cell > div > div:nth-child(3) > div:nth-child(2) div a')
    for i in perfumers:
        insert_perfumer_list.append(str(name.text))
        insert_perfumer_list.append(str(i.text))

    # 향수 노트 세 종류 구분해서 출력
    # --탑 노트
    top_note_title = driver.find_element_by_css_selector('#pyramid > div:nth-child(1) > div > '
                                                         'div:nth-child(2) > h4:nth-child(3)')
    top_notes = driver.find_elements_by_css_selector('#pyramid > div:nth-child(1) > div > div:nth-child(2) > '
                                                     'div:nth-child(4) > div div div:nth-child(2)')
    for i in top_notes:
        insert_perfume_note['perfume_name'] = name.text
        insert_perfume_note['note_group'] = top_note_title.text
        insert_perfume_note['note'] = i.text

    # --미들 노트
    middle_note_title = driver.find_element_by_css_selector('#pyramid > div:nth-child(1) > div > div:nth-child(2) > '
                                                            'h4:nth-child(5)')
    middle_notes = driver.find_elements_by_css_selector('#pyramid > div:nth-child(1) > div > div:nth-child(2) > '
                                                        'div:nth-child(6) > div div div:nth-child(2)')
    for i in middle_notes:
        insert_perfume_note['perfume_name'] = name.text
        insert_perfume_note['note_group'] = middle_note_title.text
        insert_perfume_note['note'] = i.text

    # --베이스 노트
    base_note_title = driver.find_element_by_css_selector('#pyramid > div:nth-child(1) > div > div:nth-child(2) > '
                                                          'h4:nth-child(7)')
    base_notes = driver.find_elements_by_css_selector('#pyramid > div:nth-child(1) > div > div:nth-child(2) > '
                                                      'div:nth-child(8) > div div div:nth-child(2)')
    for i in base_notes:
        insert_perfume_note['perfume_name'] = name.text
        insert_perfume_note['note_group'] = base_note_title.text
        insert_perfume_note['note'] = i.text

    print(insert_perfumer_list)
    print(insert_accords)
    print(insert_perfume_info)
    print(insert_perfume_note)

    # 저장하기
    oracleCursor.execute('insert into perfumer_list values(:1, :2)', insert_perfumer_list)

    # 향수 이미지 다운로드
    perfume_img_link = driver.find_element_by_xpath('//*[@id="main-content"]/div[1]/div[1]/div/div[2]/div[1]/'
                                               'div[1]/div/div/img').get_attribute('src')
    # path_folder의 경로는 각자 저장할 폴더의 경로를 적어줄 것(ex.img_download)
    path_folder = './img/'

    if not os.path.isdir(path_folder):
        os.mkdir(path_folder)

    urlretrieve(perfume_img_link, path_folder + f'{name.text}.jpg')

oracleCursor.close()
driver.close()
driver.quit()
