--�����₢���킹�ŕ\������Ă݂�
CREATE TABLE ���ҁ[��񂵂�[ AS SELECT empno �΂񂲂�, ename �Ȃ܂�, dname ����Ƃ�
FROM emp e FULL OUTER JOIN dept d
ON e.deptno = d.deptno;

--���J���������C�ɓ���Ȃ��̂ŕς��Ă݂�
ALTER TABLE ���ҁ[��񂵂�[ RENAME COLUMN ����Ƃ� TO ��邱��;

--���ϊ��֐����g���Ă݂�
SELECT �΂񂲂�,�Ȃ܂�,NVL(��邱��,' ! NEET ! ') ��邱�� FROM ���ҁ[��񂵂�[;

--������t���Y�ꂽ�̂Œǉ����Ă݂�
ALTER TABLE ���ҁ[��񂵂�[ ADD CONSTRAINT pk_�΂񂲂� PRIMARY KEY(�΂񂲂�);