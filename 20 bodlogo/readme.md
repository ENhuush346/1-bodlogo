# 📊 Frequency Queries — Давтамжийн лавлагаа

## 📌 Бодлогын тайлбар

Танд дараах хэлбэртэй `q` ширхэг лавлагаа (`query`) өгөгднө:

- `1 x` 👉 `x` тоог дата бүтэц рүү нэм.
- `2 y` 👉 Хэрвээ `y` тоо байгаа бол нэг удаа устга.
- `3 z` 👉 Ямар нэг тоо `z` удаа давтагдаж байвал `1`, үгүй бол `0` гэж хэвлэ.

🎯 Зорилго: Бүх `3 z` хэлбэрийн асуултын үр дүнг дарааллаар нь гаргах.

---

## 🧠 Ойлголт

Давтамж болон давтамжийн тоогоор `dict`-үүд ашиглана:

- `freq[x]`: `x` тоо хэдэн удаа байгаа вэ?
- `freqCount[f]`: `f` давтамжтай хэдэн тоо байна?

🟢 `1 x` үед:
- `x` тооны давтамжийг нэмнэ.
- Шинэ ба хуучин давтамжийг `freqCount`-д шинэчилнэ.

🔴 `2 y` үед:
- `y` тоо байвал 1 удаа хасна.
- Давтамжийг `freqCount`-д шинэчилнэ.

🔵 `3 z` үед:
- Хэрвээ `z` давтамжтай тоо байвал `1`, үгүй бол `0`.

### 📝 Тайлбар:

- 3-р мөр дээр 2 удаа давтагдсан тоо байхгүй → `0`
- 8-р мөр дээр 2 удаа давтагдсан `6`, `10` байна → `1`

---

## 🧮 Код (Python)

```python
def freqQuery(queries):
    freq = {}
    freqCount = {}
    result = []

    for op, val in queries:
        if op == 1:
            old_freq = freq.get(val, 0)
            new_freq = old_freq + 1
            freq[val] = new_freq

            freqCount[old_freq] = freqCount.get(old_freq, 0) - 1 if old_freq > 0 else freqCount.get(old_freq, 0)
            freqCount[new_freq] = freqCount.get(new_freq, 0) + 1

        elif op == 2:
            old_freq = freq.get(val, 0)
            if old_freq > 0:
                new_freq = old_freq - 1
                freq[val] = new_freq

                freqCount[old_freq] = freqCount.get(old_freq, 0) - 1
                freqCount[new_freq] = freqCount.get(new_freq, 0) + 1

        else:
            result.append(1 if freqCount.get(val, 0) > 0 else 0)

    return result
