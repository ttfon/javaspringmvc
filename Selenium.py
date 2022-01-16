from typing import List
from selenium import webdriver
import time
browser = webdriver.Chrome("E:/python/abc/chromedriver.exe")
browser.get('http://localhost:8080/quanli/')
username = "toantoan14"
password = "123456"
usernameAdmin = "admin"
passAdmin ="admin"
def dangki():
    browser.find_element_by_css_selector('#navbarReponsive > ul > li:nth-child(2) > a').click()
    browser.find_element_by_name("username").send_keys(username)
    browser.find_element_by_name("password").send_keys(password)
    browser.find_element_by_name("hoten").send_keys("Tran Huy Toan")
    browser.find_element_by_name("email").send_keys("1851010138toan11@ou.edu.vn")
    browser.find_element_by_name("sdt").send_keys("0941193169")
    browser.find_element_by_name("ngaysinh").send_keys("14/03/2000")
    browser.find_element_by_css_selector("body > div.img-fluid > div > form > div:nth-child(7) > input").click()
    if(browser.current_url == "http://localhost:8080/quanli/login"):
        print("passed")
    else:
        print("failed")
        
def dangnhap():
    browser.find_element_by_css_selector('#navbarReponsive > ul > li:nth-child(1) > a').click()
    browser.find_element_by_name("username").send_keys(usernameAdmin)
    browser.find_element_by_name("password").send_keys(passAdmin)
    browser.find_element_by_css_selector("body > div.img-fluid > div > form > div:nth-child(3) > input").click()
    if(browser.current_url == "http://localhost:8080/quanli/"):
        print("passed")
    else:
        print("failed")
def layThongTin():
    dangnhap()
    browser.find_element_by_css_selector('#navbardrop').click()
    browser.find_element_by_css_selector('#navbarReponsive > ul > li > div > a:nth-child(2)').click()
    thongtin = browser.find_element_by_css_selector('body > div.row > div.contentright > div').text
    print(thongtin)
def xoaUser():
    dangnhap()
    browser.get('http://localhost:8080/quanli/admin/user')  
    textt = browser.find_elements_by_css_selector('body > div.row > div.contentright > table > tbody > tr')
    i = 0
    for txt in textt:
        i = i+1
    browser.find_element_by_css_selector('body > div.row > div.contentright > table > tbody > tr:nth-child('+str(i)+') > td:nth-child(7) > a.btn.btn-danger').click()
    alert = browser.switch_to.alert
    alert.accept()
    browser.get('http://localhost:8080/quanli/admin/user') 
    textt = browser.find_elements_by_css_selector('body > div.row > div.contentright > table > tbody > tr')
    y = 0
    for txt in textt:
        y = y+1
    if(i != y):
        print("passed")
    else:
        print("failed")
def updateUser():
    dangnhap()
    browser.get('http://localhost:8080/quanli/admin/user')  
    textt = browser.find_elements_by_css_selector('body > div.row > div.contentright > table > tbody > tr')
    i = 0
    for txt in textt:
        i = i+1
    browser.find_element_by_css_selector('body > div.row > div.contentright > table > tbody > tr:nth-child('+str(i)+') > td:nth-child(7) > a.btn.btn-primary').click()
    browser.find_element_by_name("password").clear()
    browser.find_element_by_name("password").send_keys(password)
    browser.find_element_by_name("hoten").clear()
    browser.find_element_by_name("hoten").send_keys("Tran Huy Toan")
    browser.find_element_by_css_selector('body > div.container > form > div:nth-child(10) > input').click()
def datvexe():
    dangnhap()
    browser.get('http://localhost:8080/quanli/chuyenxe')
    browser.find_element_by_css_selector('body > div.row > div.col-md-8 > div:nth-child(3) > div > div:nth-child(1) > div > a').click()
    browser.find_element_by_css_selector('body > div.container > div > div.box > div.box-gia-tour > table > tbody > tr:nth-child(2) > td > a').click()
    browser.find_element_by_css_selector('body > div.container > div > div.box > div.box-gia-tour > table > tbody > tr:nth-child(3) > td > strong:nth-child(1) > a').click()
    browser.find_element_by_css_selector('body > div > a:nth-child(3)').click()
    if(browser.current_url != "http://localhost:8080/quanli/chuyenxe/cart"):
        print("passed")
    else:
        print("failed")