-- 코드를 입력하세요
WITH APNT AS (
    SELECT *
    FROM APPOINTMENT
    WHERE APNT_YMD LIKE '2022-04-13%' AND APNT_CNCL_YN = 'N'
)

SELECT APNT_NO, PT_NAME, P.PT_NO, D.MCDP_CD, D.DR_NAME, A.APNT_YMD
FROM PATIENT P JOIN APNT A ON P.PT_NO = A.PT_NO
    JOIN DOCTOR D ON D.DR_ID = A.MDDR_ID
ORDER BY APNT_YMD ASC