SELECT I.ITEM_ID, ITEM_NAME, RARITY
FROM ITEM_INFO I JOIN ITEM_TREE T ON I.ITEM_ID = T.ITEM_ID
WHERE PARENT_ITEM_ID IN (SELECT I.ITEM_ID
    FROM ITEM_INFO I
    WHERE RARITY = 'RARE')
ORDER BY ITEM_ID DESC