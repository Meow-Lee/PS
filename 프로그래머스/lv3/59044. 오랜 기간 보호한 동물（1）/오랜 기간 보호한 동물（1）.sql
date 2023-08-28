-- 코드를 입력하세요
SELECT a.name, a.datetime
from animal_ins as a
left join animal_outs as b on a.animal_id = b.animal_id
where b.datetime is null
order by datetime asc
limit 3;