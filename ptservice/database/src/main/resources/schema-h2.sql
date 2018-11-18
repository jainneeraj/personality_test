DROP TABLE IF EXISTS  pt_questions;

CREATE TABLE pt_questions (id number, question_json varchar(5000), category varchar(50));  

insert into PT_QUESTIONS values(1,'{ "question": "What is your gender?", "category": "hard_fact", "question_type": { "type": "single_choice", "options": [ "male", "female", "other" ] } }','hard_fact');
insert into PT_QUESTIONS values(2,'{
      "question": "How important is the gender of your partner?",
      "category": "hard_fact",
      "question_type": {
        "type": "single_choice",
        "options": [
          "not important",
          "important",
          "very important"
        ]
      }
    }','hard_fact');
insert into PT_QUESTIONS values(3,'{
      "question": "How important is the age of your partner to you?",
      "category": "hard_fact",
      "question_type": {
        "type": "single_choice_conditional",
        "options": [
          "not important",
          "important",
          "very important"
        ],
        "condition": {
          "predicate": {
            "exactEquals": [
              "${selection}",
              "very important"
            ]
          },
          "if_positive": {
            "question": "What age should your potential partner be?",
            "category": "hard_fact",
            "question_type": {
              "type": "number_range",
              "range": {
                "from": 18,
                "to": 140
              }
            }
          }
        }
      }
    }','hard_fact');    
    
    insert into PT_QUESTIONS values(4,' {
      "question": "Do any children under the age of 18 live with you?",
      "category": "hard_fact",
      "question_type": {
        "type": "single_choice",
        "options": [
          "yes",
          "sometimes",
          "no"
        ]
      }
    }','hard_fact');  
   
   
   
   
   
   