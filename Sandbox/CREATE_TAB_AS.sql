--■副問い合わせで表を作ってみる
CREATE TABLE こぴーれんしゅー AS SELECT empno ばんごう, ename なまえ, dname いるとこ
FROM emp e FULL OUTER JOIN dept d
ON e.deptno = d.deptno;

--■カラム名が気に入らないので変えてみる
ALTER TABLE こぴーれんしゅー RENAME COLUMN いるとこ TO やること;

--■変換関数を使ってみる
SELECT ばんごう,なまえ,NVL(やること,' ! NEET ! ') やること FROM こぴーれんしゅー;

--■制約付け忘れたので追加してみる
ALTER TABLE こぴーれんしゅー ADD CONSTRAINT pk_ばんごう PRIMARY KEY(ばんごう);