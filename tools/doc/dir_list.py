# 目录树
import os

dirpath = 'E:\workspace\carloan-xinzhen\eloan-main\car-manager\src\main\\resources'
rootpath = ''

def travelTree(currentPath, count):
    if not os.path.exists(currentPath):
        return
    if os.path.isfile(currentPath):
        fileName = os.path.basename(currentPath)
        print('\t' * count + '├── ' + fileName)
    elif os.path.isdir(currentPath):
        print('\t' * count + '├── ' + currentPath[29:])
        pathList = os.listdir(currentPath)
        for eachPath in pathList:
            travelTree(currentPath + '\\' + eachPath, count + 1)

travelTree(dirpath, 1)