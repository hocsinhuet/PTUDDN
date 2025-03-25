#!/bin/bash

# Lấy thông tin ngày giờ hiện tại làm commit message
DATE=$(date +"%Y-%m-%d %H:%M:%S")

# Thực hiện các bước tự động push
git add .
git commit -m "Auto commit - $DATE"
git push origin main

echo "✅ Code đã tự động push lên GitHub!"
