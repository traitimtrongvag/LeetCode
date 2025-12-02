#!/bin/bash

# Duyệt toàn bộ project và đổi tên tất cả file main.xxx → solution.xxx
find . -type f -name "main.*" | while read file; do
    dir=$(dirname "$file")   # Lấy thư mục chứa file
    base=$(basename "$file") # Lấy tên file: main.rs, main.cpp...

    ext="${base#*.}"         # Lấy phần mở rộng: rs, cpp, c, java...

    new="$dir/solution.$ext" # Tên file mới: solution.rs...

    echo "Đổi: $file  →  $new"
    mv "$file" "$new"
done

echo "Hoàn tất!"
