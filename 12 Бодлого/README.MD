# Grid Challenge
https://www.hackerrank.com/challenges/grid-challenge/problem
---

## 📖 Тайлбар

`n` мөр, `m` багана бүхий тэмдэгтийн сүлжээ өгөгдөнө.  
Эхлээд мөр бүрийн тэмдэгтүүдийг үсгийн дарааллаар эрэмбэлнэ.  
Дараа нь багануудыг дээшээс доош шалгахад бүх багана өсөх дарааллаар байрласан эсэхийг шалгана.  
Хэрэв бүх багана өсөх дарааллаар байвал **YES**, үгүй бол **NO** гэж хэвлэнэ.

---

## 🎯 Оролт

- `n` — мөрний тоо  
- `m` — баганын тоо (үлдээж өгөгдөнө)  
- `grid` — `n` мөр бүхий тэмдэгтийн массив

---

## 🏆 Гаралт

- YES эсвэл NO

---

## 💻 Шийдэл (C++)

```cpp
#include <bits/stdc++.h>
using namespace std;

string gridChallenge(vector<string> grid) {
    for (auto &row : grid) {
        sort(row.begin(), row.end());
    }

    int rows = grid.size();
    int cols = grid[0].size();

    for (int col = 0; col < cols; col++) {
        for (int row = 1; row < rows; row++) {
            if (grid[row][col] < grid[row - 1][col]) {
                return "NO";
            }
        }
    }

    return "YES";
}

int main() {
    int n;
    cin >> n;
    vector<string> grid(n);

    for (int i = 0; i < n; i++) {
        cin >> grid[i];
    }

    cout << gridChallenge(grid) << endl;
    return 0;
}
