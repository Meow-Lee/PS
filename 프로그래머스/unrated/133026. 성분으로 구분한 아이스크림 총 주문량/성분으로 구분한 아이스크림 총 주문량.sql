-- 코드를 입력하세요
SELECT b.ingredient_type, sum(a.total_order) as total_order
from first_half as a, icecream_info as b
where a.flavor = b.flavor
group by b.ingredient_type
order by total_order;