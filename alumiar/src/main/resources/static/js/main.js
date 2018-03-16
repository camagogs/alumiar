$(document).ready(
		function() {

			$("#ong1").click(function() {
				$("#modal1").fadeIn(600);
				$("#modal1").css('top', $(document).scrollTop());
				$("html, body").css({
					"overflow" : "hidden"
				});
			})
			$("#ong2").click(function() {
				$("#modal2").fadeIn(600);
				$("#modal2").css('top', $(document).scrollTop());
				$("html, body").css({
					"overflow" : "hidden"
				});
			})
			$("#ong3").click(function() {
				$("#modal3").fadeIn(600);
				$("#modal3").css('top', $(document).scrollTop());
				$("html, body").css({
					"overflow" : "hidden"
				});
			})
			$("#ong4").click(function() {
				$("#modal4").fadeIn(600);
				$("#modal4").css('top', $(document).scrollTop());
				$("html, body").css({
					"overflow" : "hidden"
				});
			})
			$("#img-adocao").click(function() {
				$("#modal-adocao").fadeIn(600);
				$("#modal-adocao").css('top', $(document).scrollTop());
				$("html, body").css({
					"overflow" : "hidden"
				});
			})
			$(".sair").click(function() {
				$(this.closest('section')).fadeOut(600);
				$("html, body").css({
					"overflow" : "auto"
				});
			})

			$(".sanduiche").click(function() {
				$(".menu").fadeIn(400);
				$(".menu").css('top', $(document).scrollTop());
				$("html, body").css({
					"overflow" : "hidden"
				});
			})

			$(".scrollSuave").on('click', function(e) {
				$("html, body").css({
					"overflow" : "auto"
				});
				$(".menu").hide();

				$('html, body').animate({
					scrollTop : $($.attr(this, 'href')).offset().top
				}, 500);
				return false;
			});
			$(".ensaio-detalhe").hide()

			$(".en-1").click(function() {
				$(".ensaio-detalhe").toggle();
				$(".icone-mais").toggle();
			})
			$("#foto-slide").addClass("ativo").show();
			$(".dir").click(
					function() {
						if ($(".ativo").next().length) {
							$(".ativo").fadeOut().removeClass("ativo").next()
									.fadeIn().addClass("ativo");
						} else {
							$(".ativo").fadeOut().removeClass("ativo");
							$("#slide-ensaio img").fadeIn().addClass("ativo");
						}
					})
			$(".esq").click(
					function() {
						if ($(".ativo").prev().length) {
							$(".ativo").fadeOut().removeClass("ativo").prev()
									.fadeIn().addClass("ativo");
						} else {
							$(".ativo").fadeOut().removeClass("ativo");
							$("#slide-ensaio img").fadeIn().addClass("ativo");
						}
					})
		});
// e.preventDefault();
// var id = $(this).attr('href'),
//         targetOffset = $(id).offset().top;

// $('html, body').animate({ 
//     scrollTop: targetOffset - 0
// }, 500);  

// var $doc = $('html, body');
// $(".scrollSuave").click(function() {
//     $doc.animate({
//         scrollTop: $( $.attr(this, 'href') ).offset().top
//     }, 600);      
// return false;
// });