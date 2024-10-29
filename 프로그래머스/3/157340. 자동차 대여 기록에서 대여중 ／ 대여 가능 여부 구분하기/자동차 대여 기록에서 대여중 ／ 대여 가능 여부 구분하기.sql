-- 코드를 입력하세요
WITH CAR_AVAILABILITY AS (
    SELECT CAR_ID,
        CASE 
            WHEN START_DATE <= '2022-10-16' AND END_DATE >= '2022-10-16' THEN 1
            ELSE 0
        END AS AVAILABILITY
    FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY
)

SELECT CAR_ID,
    CASE
        WHEN MAX(AVAILABILITY) = 1 THEN '대여중'
        ELSE '대여 가능'
    END AS AVAILABILITY
FROM CAR_AVAILABILITY
GROUP BY CAR_ID
ORDER BY CAR_ID DESC