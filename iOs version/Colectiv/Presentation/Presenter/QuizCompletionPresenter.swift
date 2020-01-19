//
//  QuizCompletionPresenter.swift
//  Colectiv
//
//  Created by Lobont Andrei on 17/01/2020.
//  Copyright © 2020 Andrei Lobont. All rights reserved.
//

import Foundation

class QuizCompletionPresenter {
    private weak var view: QuizCompletionView?
    private weak var navigation: QuizCompletionNavigation?
    let quiz: Quiz
    let correctAnswers: Int
    private(set) var user: User? {
        get {
            guard let persistentValue = UserDefaults.standard.value(forKey: "user") as? Data,
                let user = try? JSONDecoder().decode(User.self, from: persistentValue) else {
                    return nil
            }
            return user
        }
        
        set {
            let data = try? JSONEncoder().encode(newValue)
            UserDefaults.standard.set(data, forKey: "user")
        }
    }
    
    init(view: QuizCompletionView, navigation: QuizCompletionNavigation, correctAnswers: Int, quiz: Quiz) {
        self.view = view
        self.navigation = navigation
        self.correctAnswers = correctAnswers
        self.quiz = quiz
    }
    
    func viewDidLoad() {
        view?.displayCorrectAnswers(answers: correctAnswers)
        var usr = user
        usr?.completezQuizes.append(quiz)
        user = usr
//        user?.completezQuizes.append(quiz)
    }
    
    func navigationButtonPressed() {
        navigation?.navigateToQuiz()
    }
}
