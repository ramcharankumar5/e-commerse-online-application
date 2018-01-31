$(function()
{
	switch(menu)
	{
	
	case 'About us':
	     $('#about').addClass('active');
	     break;
	     
	case 'Contact us':
	     $('#contact').addClass('active');
	     break;
	defalut:
		$('#home').addClass('active');	
	}
	
	
	
	/*var products=[
	              ['1','abc'],
	              ['2','abc'],
	              ['3','abc'],
	              ['4','abc'],
	              ['5','abc'],
	              ['6','abc'],
	              ['7','abc'],
	              ['8','abc'],
	              ['9','abc'],
	              ['10','abc'],
	              ['11','abc'],
	              ['12','abc'],
	              ['13','xyz'],

	              ];*/
	
	var $table = $('#productListTable');
	if ($table.length) {
		//console.log('Iam inside the table');
		var jsonUrl ='';
		if(window.categoryId=='')
			{
			jsonUrl=window.contextRoot + '/json/data/all/products';

			}
		else
			{
			
			jsonUrl=window.contextRoot + '/json/data/{'+window.categoryId+'}/products';

			}
		

		$table.DataTable({
			
lengthMenu : [ [ 3, 5, 10, -1 ],
				[ '3 Records', '5 Records', '10 Records', 'ALL' ] ],
		pageLength : 5,
		ajax : {
			url : jsonUrl,
			dataSrc : ''
		},
		
		columns : [		
		         
		           	{
						data : 'name'
					},
					{
						data : 'brand'
					},
					{
						data : 'quantity',
					

						
					},
					{
						data : 'unitPrice',
						
					},
							           	
		],
		
		
		});
				
		
		
		
		
		
		
	}
	
	
	});