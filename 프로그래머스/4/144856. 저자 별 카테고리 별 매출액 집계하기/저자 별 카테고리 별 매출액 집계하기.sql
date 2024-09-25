-- 코드를 입력하세요
SELECT B.AUTHOR_ID, AUTHOR_NAME, CATEGORY, SUM(SALES * PRICE) TOTAL_SALES
FROM BOOK B
    JOIN AUTHOR A ON B.AUTHOR_ID = A.AUTHOR_ID
    JOIN BOOK_SALES S ON B.BOOK_ID = S.BOOK_ID
WHERE YEAR(SALES_DATE) = 2022 AND MONTH(SALES_DATE) = 1
GROUP BY B.AUTHOR_ID, CATEGORY
ORDER BY AUTHOR_ID ASC, CATEGORY DESC