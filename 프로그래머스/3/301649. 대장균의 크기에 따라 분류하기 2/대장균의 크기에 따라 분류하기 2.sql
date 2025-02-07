with total as(
    select count(*) as cnt  from ECOLI_DATA 
)

select A.ID,
    case 
        when B.cnt * 0.75  < A.size then "CRITICAL"
        when B.cnt * 0.50  < A.size then "HIGH"
        when B.cnt * 0.25  < A.size then "MEDIUM"
        else "LOW"
    end as COLONY_NAME
from(
    select ID, ROW_NUMBER() over(order by SIZE_OF_COLONY) as size
    from ECOLI_DATA
) A, total B
order by ID 

