SELECT 
    A.CAR_ID, 
    A.CAR_TYPE, 
    round(((A.DAILY_FEE*30) - (A.DAILY_FEE *30*(C.DISCOUNT_RATE*0.01))), 0) as FEE
from
    CAR_RENTAL_COMPANY_CAR A 
inner join 
    CAR_RENTAL_COMPANY_DISCOUNT_PLAN C ON A.CAR_TYPE = C.CAR_TYPE
where 
    A.CAR_TYPE in ('세단', 'SUV')
    and (A.DAILY_FEE*30) - (A.DAILY_FEE *30*(C.DISCOUNT_RATE*0.01))  between 500000 and 2000000
    and C.DURATION_TYPE ='30일 이상'
    and A.CAR_ID not in(
        select CAR_ID
        from CAR_RENTAL_COMPANY_RENTAL_HISTORY
        where START_DATE <= '2022-11-30' AND END_DATE  >= '2022-11-01' 
    )
order by FEE DESC, CAR_TYPE ASC, CAR_ID DESC





/*
대여 금액 내림, 종류 기준 오름차순, I D 기준 내림차순
*/
       