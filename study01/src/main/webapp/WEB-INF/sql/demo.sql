#namespace("blog")
	#sql("list")
		select * from t_blog order by id asc
	#end
	
	#sql("findOne")
		select * from t_blog where id=?
	#end
	
	#sql("between")
		select * from t_blog where id>=? and id<=?
	#end
	
	#sql("between_new")
		select * from t_blog where id>=#p(min_1) and id<=#p(max_1)
	#end
#end