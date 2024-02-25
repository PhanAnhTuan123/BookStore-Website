<c:forEach items="${listBestSellingBook}" var="book">
					<div style="display: inline-block; margin: 10px;">
						<div>
							<a href="view_book?id=${book.bookId}"> <img
								src="data:image/jpg;base64,${book.base64Image}" width="128"
								height="164" />
							</a>
						</div>
						<a href="view_book?id=${book.bookId}"> <b>${book.title}</b>
						</a>
					</div>
					 
					<div>
					<c:forTokens items="${book.ratingStars}" delims="," var="star">
						<c:if test="${star eq 'on' }">
							<img alt="" src="images/rating_on.png" />
						</c:if>
							<c:if test="${star eq 'off' }">
							<img alt="" src="images/rating_off.png" />
						</c:if>
										<c:if test="${star eq 'half' }">
							<img alt="" src="images/rating_half.png" />
						</c:if>
		
					</c:forTokens>
					</div>
						<div>
						<i>by ${book.author}</i>
					</div>
						<div>
						<b>$ ${book.price}</b>
					</div>
				</c:forEach>