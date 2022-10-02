<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        
        <!-- SEO Meta Tags -->
        <meta name="description" content="Your description">
        <meta name="author" content="Your name">

        <!-- OG Meta Tags to improve the way the post looks when you share the page on Facebook, Twitter, LinkedIn -->
        <meta property="og:site_name" content="" /> <!-- website name -->
        <meta property="og:site" content="" /> <!-- website link -->
        <meta property="og:title" content=""/> <!-- title shown in the actual shared post -->
        <meta property="og:description" content="" /> <!-- description shown in the actual shared post -->
        <meta property="og:image" content="" /> <!-- image link, make sure it's jpg -->
        <meta property="og:url" content="" /> <!-- where do you want your post to link to -->
        <meta name="twitter:card" content="summary_large_image"> <!-- to have large image post format in Twitter -->

        <!-- Webpage Title -->
        <title>Ioniq Webpage Title</title>
        
        <!-- Styles -->
        <link href="https://fonts.googleapis.com/css2?family=Open+Sans:ital,wght@0,400;0,600;1,400&display=swap" rel="stylesheet">
        <link href="/resources/dist/css/bootstrap.min.css" rel="stylesheet">
        <link href="/resources/dist/css/fontawesome-all.min.css" rel="stylesheet">
        <link href="/resources/dist/css/swiper.css" rel="stylesheet">
        <link href="/resources/dist/css/styles.css" rel="stylesheet">
        
        <!-- Favicon  -->
        <link rel="icon" href="/resources/dist/images/favicon.png">
    </head>
    <body data-bs-spy="scroll" data-bs-target="#navbarExample">
        
        <!-- Navigation -->
        <nav id="navbarExample" class="navbar navbar-expand-lg fixed-top navbar-light" aria-label="Main navigation">
            <div class="container">

                <!-- Image Logo -->
                <a class="navbar-brand logo-image" href="/"><img src="/resources/dist/images/logo.svg" alt="alternative"></a> 

                <!-- Text Logo - Use this if you don't have a graphic logo -->
                <!-- <a class="navbar-brand logo-text" href="index.html">Ioniq</a> -->

                <button class="navbar-toggler p-0 border-0" type="button" id="navbarSideCollapse" aria-label="Toggle navigation">
                    <span class="navbar-toggler-icon"></span>
                </button>

                <div class="navbar-collapse offcanvas-collapse" id="navbarsExampleDefault">
                    <form class="d-flex" action="/brd/search" method="get">
                      <select class="form-select" name="range">
								        <option value="title">제목</option>
								        <option value="description">내용</option>
								        <option value="writer">작성자</option>
								      </select>
							        <input class="form-control me-2" type="text" placeholder="Search" name="keyword" value="${keyword }">
							        <button class="btn-outline-sm" type="submit">Search</button>
							      </form>
                    <ul class="navbar-nav ms-auto navbar-nav-scroll">
                        <li class="nav-item">
                            <a class="nav-link active" aria-current="page" href="/">Home</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="/mem/list">Member List</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="/brd/list">Board</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="/pd/list">Product</a>
                        </li>
                        <li class="nav-item dropdown">
                          <c:if test="${ses eq null }">
                            <a class="nav-link dropdown-toggle" href="#" id="dropdown01" data-bs-toggle="dropdown" aria-expanded="false">Drop</a>
                            <ul class="dropdown-menu" aria-labelledby="dropdown01">
                                <li><a class="dropdown-item" href="/">Article Details</a></li>
                                <li><div class="dropdown-divider"></div></li>
                                <li><a class="dropdown-item" href="/">Terms Conditions</a></li>
                                <li><div class="dropdown-divider"></div></li>
                                <li><a class="dropdown-item" href="/">Privacy Policy</a></li>
                            </ul>
                           </c:if>
                          <c:if test="${ses ne null }">
                            <a class="nav-link dropdown-toggle" href="#" id="dropdown01" data-bs-toggle="dropdown" aria-expanded="false">${ses.email }</a>
                            <ul class="dropdown-menu" aria-labelledby="dropdown01">
                                <li><a class="dropdown-item" href="/mem/modify?em=${ses.email }">${ses.nick_name } 님</a></li>
                                <li><div class="dropdown-divider"></div></li>
                                <li><a class="dropdown-item" href="/">회원등급 : ${ses.grade }</a></li>
                            </ul>
                           </c:if>
                        </li>
                    </ul>
                    <span class="nav-item">
                      <c:if test="${ses eq null }">
                        <a class="btn-outline-sm" href="/mem/login">Login</a>
                      </c:if>
                      <c:if test="${ses ne null }">
                        <a class="btn-outline-sm" href="/mem/logout">Logout</a>
                      </c:if>
                    </span>
                </div> <!-- end of navbar-collapse -->
            </div> <!-- end of container -->
        </nav> <!-- end of navbar -->
        <!-- end of navigation -->