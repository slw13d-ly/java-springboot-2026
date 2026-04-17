INSERT INTO MOVIE VALUES (
    SEQ_MOVIE.NEXTVAL,
    '인터스텔라',
    'Interstellar',
    '크리스토퍼 놀란',
    '매튜 맥커너히, 앤 해서웨이',
    'Sci-Fi',
    TO_DATE('2014-11-06', 'YYYY-MM-DD'),
    169,
    8.7,
    '우주를 배경으로 한 인류 생존 이야기',
    SYSDATE,
    NULL
);

SELECT * FROM MOVIE;

COMMIT;