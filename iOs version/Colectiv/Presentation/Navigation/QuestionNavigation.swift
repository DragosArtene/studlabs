//
//  QuestionNavigation.swift
//  Colectiv
//
//  Created by Andrei Lobont on 17/01/2020.
//  Copyright © 2020 Andrei Lobont. All rights reserved.
//

import Foundation

protocol QuestionNavigation: class {
    func navigateToEndOfQuiz(with correctAnswers: Int, and quiz: Quiz)
}
