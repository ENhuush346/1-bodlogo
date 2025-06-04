# Sherlock and Anagrams
https://www.hackerrank.com/challenges/flipping-bits/problem
## Бодлогын утга
Өгөгдсөн `s` тэмдэгтэн цуваанд агуулагдах бүх анихрам (anagram) үүсвэрүүдийг олно.  
Өөрөөр хэлбэл, `s` доторх бүх хэсгийн мөрүүдээс бие биенийхээ анихрам болох хосуудын тоог тоолно.
## Оролт, гаралт

| Оролт | Гаралт |
|-------|---------|
| "abba" | 4       |

## Шийдэл арга

1. Бүх боломжит substring-үүдийг олно.  
2. Тухайн substring-үүдийг үсэгнүүдээр нь эрэмбэлж жигд төлөвт оруулна.  
3. Ижил төлөвтэй substring-үүдийн тоог тоолно.  
4. Хэрвээ ямар нэгэн төлөвийн substring-үүд `n` удаа гарвал тухайн төлөвөөс `n*(n-1)/2` хос үүснэ.  
5. Бүх төлөвийн хосуудыг нийлүүлнэ.

## Код

```java
public static int sherlockAndAnagrams(String s) {
    int count = 0;
    Map<String, Integer> map = new HashMap<>();

    for (int i = 0; i < s.length(); i++) {
        for (int j = i + 1; j <= s.length(); j++) {
            char[] sub = s.substring(i, j).toCharArray();
            Arrays.sort(sub);
            String key = new String(sub);
            map.put(key, map.getOrDefault(key, 0) + 1);
        }
    }

    for (int val : map.values()) {
        count += val * (val - 1) / 2;
    }

    return count;
}
