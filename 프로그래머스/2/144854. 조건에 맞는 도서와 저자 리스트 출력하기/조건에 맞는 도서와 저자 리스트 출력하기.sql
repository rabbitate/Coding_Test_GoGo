SELECT BOOK_ID, AUTHOR_NAME, DATE_FORMAT(PUBLISHED_DATE, '%Y-%m-%d')
FROM BOOK B
    JOIN AUTHOR A
    ON B.AUTHOR_ID = A.AUTHOR_ID
WHERE BOOK_ID IN (
    SELECT BOOK_ID
    FROM BOOK
    WHERE CATEGORY = '경제'
)
ORDER BY PUBLISHED_DATE ASC