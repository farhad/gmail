package com.google.mail.components

data class MailItem(
    val id: Int,
    val sender: String,
    val subject: String,
    val body: String,
    val timeStamp: String
) {

    companion object {
        fun getList(): List<MailItem> {
            val list = listOf(
                MailItem(
                    1,
                    "Christy",
                    "Offer Letter",
                    "Please find the offer letter attached to this email",
                    "10:25"
                ),
                MailItem(
                    2,
                    "Amazon.ca",
                    "Amazon gift card",
                    "Just following up on your $50 Amazon gift card. Did you receive it?",
                    "9:25"
                ),
                MailItem(
                    3,
                    "TLDR",
                    "Web Development Newsletter, Feb 26, 2023",
                    "Here's what has been happening in web development scene during this week",
                    "7:00"
                ),
                MailItem(
                    4,
                    "RBC Royal Bank",
                    "Deposit Notice",
                    "A deposit of 489.45 was made to your chequing account",
                    "3:25"
                ),
                MailItem(
                    5,
                    "Android Weekly",
                    "Android Weekly #555",
                    "Issue #555 of weekly Android newsletter",
                    "2:25"
                ),
                MailItem(
                    6,
                    "discovery+",
                    "new shows announcement",
                    "How are you missing all these great shows and documentaries on discovery+?",
                    "1:30"
                ),
                MailItem(
                    7,
                    "Canadian Red Cross",
                    "Ukraine - your impact in 1 year",
                    "See how you have helped people impacted by the war in Ukraine...",
                    "12:00"
                ),
            )

            return list + list
        }
    }
}