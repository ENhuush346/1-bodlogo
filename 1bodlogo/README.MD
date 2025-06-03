# Coin Change Problem

## ✅ Бодлогын нөхцөл 
Танд `n` гэсэн нийт мөнгө байгаа ба `coins[]` гэсэн янз бүрийн зоосны төрлүүд байна. Танд хэдэн аргаар энэ `n` мөнгийг эдгээр зоос ашиглан төлж болох вэ?

n = 4
coins = {1, 2, 3}  гэхлээр  4 арга байна
4 = 1+1+1+1
4 = 1+1+2
4 = 1+3
4 = 2+2
=> нийт 4 арга байна.


## 🧠 Алгоритмын санаа
Dynamic Programming ашиглана. dp[i] гэдэг нь i мөнгийг олох арга замын тоо гэж үзнэ.

## ⏱ Time Complexity
O(n * m), энд n = нийт мөнгө, m = зоосны төрөл

## 🔗 Бодлогын холбоос
[https://www.hackerrank.com/challenges/coin-change/problem](https://www.hackerrank.com/challenges/coin-change/problem)
