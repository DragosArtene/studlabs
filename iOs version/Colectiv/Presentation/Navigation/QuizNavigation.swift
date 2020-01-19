//
//  QuizNavigation.swift
//  Colectiv
//
//  Created by Andrei Lobont on 13/01/2020.
//  Copyright © 2020 Andrei Lobont. All rights reserved.
//

import Foundation

protocol QuizNavigation: class {
    func navigateToQuestions(with quiz: Quiz)
}
