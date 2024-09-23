SELECT PRODUCT_CODE, SUM(PRICE * SALES_AMOUNT) SALES
FROM PRODUCT P
    JOIN OFFLINE_SALE S
    ON P.PRODUCT_ID = S.PRODUCT_ID
GROUP BY PRODUCT_CODE
ORDER BY SALES DESC, PRODUCT_CODE ASC