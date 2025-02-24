SELECT A.REST_ID, A.REST_NAME, A.FOOD_TYPE, A.FAVORITES, A.ADDRESS, round(avg(B.REVIEW_SCORE), 2) as score
from REST_INFO A
inner join REST_REVIEW B ON A.REST_ID = B.REST_ID
where ADDRESS like ('서울%')
group by A.rest_id
order by score DESC, A.FAVORITES DESC