with Child as(select count(*) as cnt, MAX(PARENT_ID) as ID
from ECOLI_DATA
group by PARENT_ID
)

select A.ID,  IFNULL(B.cnt , 0)AS CHILD_COUNT
from ECOLI_DATA A
left join Child B ON A.ID = B.ID 
order by A.ID
