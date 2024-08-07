-- 코드를 입력하세요
SELECT C.FLAVOR
FROM (
SELECT A.FLAVOR FLAVOR, SUM(A.TOTAL_ORDER + B.TOTAL_ORDER) TOTAL_ORDER
FROM FIRST_HALF A
JOIN(
SELECT FLAVOR, SUM(TOTAL_ORDER) TOTAL_ORDER
FROM JULY
GROUP BY FLAVOR) B
ON A.FLAVOR = B.FLAVOR
GROUP BY A.FLAVOR
ORDER BY TOTAL_ORDER DESC
LIMIT 3) C